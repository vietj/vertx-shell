package io.vertx.ext.shell.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.ext.shell.*;
import io.vertx.ext.shell.Job;
import io.vertx.ext.shell.cli.CliParser;
import io.vertx.ext.shell.cli.CliRequest;
import io.vertx.ext.shell.cli.CliToken;
import io.vertx.ext.shell.command.CommandManager;
import io.vertx.ext.shell.command.impl.ManagedCommand;
import io.vertx.ext.shell.command.impl.CommandManagerImpl;

import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ShellImpl implements Shell {

  final Vertx vertx;
  final CommandManagerImpl manager;

  public ShellImpl(Vertx vertx, CommandManager manager) {
    this.vertx = vertx;
    this.manager = (CommandManagerImpl) manager;
  }

  @Override
  public void createJob(String s, Handler<AsyncResult<Job>> handler) {
    Process process;
    try {
      process = makeRequest(s);
    } catch (Exception e) {
      handler.handle(Future.failedFuture(e));
      return;
    }
    JobProcess job = new JobProcess(vertx, process);
    handler.handle(Future.succeededFuture(job));
  }

  private Process makeRequest(String s) {
    ListIterator<CliToken> tokens = CliToken.tokenize(s).collect(Collectors.toList()).listIterator();
    while (tokens.hasNext()) {
      CliToken token = tokens.next();
      switch (token.getKind()) {
        case TEXT:
          ManagedCommand command = manager.getCommand(token.getValue());
          if (command == null) {
            throw new IllegalArgumentException(token.getValue() + ": command not found");
          }
          CliParser parser = new CliParser(command.command());
          CliRequest req = parser.parse(tokens);
          return command.createProcess(req.getOptions(), req.getArguments());
        case BLANK:
          break;
        default:
          throw new IllegalArgumentException("Bad line " + s);
      }
    }
    throw new IllegalArgumentException();
  }
}
