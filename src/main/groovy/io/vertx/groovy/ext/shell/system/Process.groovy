/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.groovy.ext.shell.system;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.ext.shell.system.ExecStatus
import io.vertx.core.Handler
import io.vertx.groovy.ext.shell.term.Tty
import io.vertx.groovy.ext.shell.session.Session
/**
 * A process managed by the shell.
*/
@CompileStatic
public class Process {
  private final def io.vertx.ext.shell.system.Process delegate;
  public Process(Object delegate) {
    this.delegate = (io.vertx.ext.shell.system.Process) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public ExecStatus status() {
    def ret = this.delegate.status();
    return ret;
  }
  /**
   * Set the process tty.
   * @param tty the process tty
   * @return this object
   */
  public Process setTty(Tty tty) {
    this.delegate.setTty((io.vertx.ext.shell.term.Tty)tty.getDelegate());
    return this;
  }
  /**
   * @return the process tty
   * @return 
   */
  public Tty getTty() {
    def ret= InternalHelper.safeCreate(this.delegate.getTty(), io.vertx.groovy.ext.shell.term.Tty.class);
    return ret;
  }
  /**
   * Set the process session
   * @param session the process session
   * @return this object
   */
  public Process setSession(Session session) {
    this.delegate.setSession((io.vertx.ext.shell.session.Session)session.getDelegate());
    return this;
  }
  /**
   * @return the process session
   * @return 
   */
  public Session getSession() {
    def ret= InternalHelper.safeCreate(this.delegate.getSession(), io.vertx.groovy.ext.shell.session.Session.class);
    return ret;
  }
  /**
   * Set an handler called when the process terminates.
   * @param handler the terminate handler
   * @return this object
   */
  public Process terminateHandler(Handler<Integer> handler) {
    this.delegate.terminateHandler(handler);
    return this;
  }
  /**
   * Run the process.
   */
  public void run() {
    this.delegate.run();
  }
  /**
   * Run the process.
   * @param completionHandler handler called after process callback
   */
  public void run(Handler<Void> completionHandler) {
    this.delegate.run(completionHandler);
  }
  /**
   * Attempt to interrupt the process.
   * @return true if the process caught the signal
   */
  public boolean interrupt() {
    def ret = this.delegate.interrupt();
    return ret;
  }
  /**
   * Attempt to interrupt the process.
   * @param completionHandler handler called after interrupt callback
   * @return true if the process caught the signal
   */
  public boolean interrupt(Handler<Void> completionHandler) {
    def ret = this.delegate.interrupt(completionHandler);
    return ret;
  }
  /**
   * Suspend the process.
   */
  public void resume() {
    this.delegate.resume();
  }
  /**
   * Suspend the process.
   * @param completionHandler handler called after resume callback
   */
  public void resume(Handler<Void> completionHandler) {
    this.delegate.resume(completionHandler);
  }
  /**
   * Resume the process.
   */
  public void suspend() {
    this.delegate.suspend();
  }
  /**
   * Resume the process.
   * @param completionHandler handler called after suspend callback
   */
  public void suspend(Handler<Void> completionHandler) {
    this.delegate.suspend(completionHandler);
  }
  /**
   * Terminate the process.
   */
  public void terminate() {
    this.delegate.terminate();
  }
  /**
   * Terminate the process.
   * @param completionHandler handler called after end callback
   */
  public void terminate(Handler<Void> completionHandler) {
    this.delegate.terminate(completionHandler);
  }
}
