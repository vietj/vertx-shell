/*
 * Copyright 2015 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 *
 *
 * Copyright (c) 2015 The original author or authors
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 *     The Eclipse Public License is available at
 *     http://www.eclipse.org/legal/epl-v10.html
 *
 *     The Apache License v2.0 is available at
 *     http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 *
 */

package io.vertx.ext.shell.term.impl;

import io.vertx.core.Handler;
import io.vertx.ext.shell.term.Pty;
import io.vertx.ext.shell.term.Tty;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class PtyImpl implements Pty {

  private int width = 80;
  private int height = 24;
  private Handler<String> stdinHandler;
  private Handler<String> stdoutHandler;
  private final String terminalType;
  private Handler<Void> resizeHandler;

  final Tty slave = new Tty() {
    @Override
    public String type() {
      return terminalType;
    }

    @Override
    public Tty stdinHandler(Handler<String> handler) {
      stdinHandler = handler;
      return this;
    }

    @Override
    public Tty write(String data) {
      if (stdoutHandler != null) {
        stdoutHandler.handle(data);
      }
      return this;
    }

    @Override
    public int width() {
      return width;
    }

    @Override
    public int height() {
      return height;
    }

    @Override
    public Tty resizehandler(Handler<Void> handler) {
      resizeHandler = handler;
      return this;
    }
  };

  public PtyImpl(String terminalType) {
    this.terminalType = terminalType;
  }

  @Override
  public Tty slave() {
    return slave;
  }

  public Pty setSize(int width, int height) {
    this.width = width;
    this.height = height;
    if (resizeHandler != null) {
      // Perhaps use a context or something ?
      resizeHandler.handle(null);
    }
    return this;
  }

  @Override
  public Pty stdoutHandler(Handler<String> handler) {
    stdoutHandler = handler;
    return this;
  }

  @Override
  public Pty write(String data) {
    if (stdinHandler != null) {
      stdinHandler.handle(data);
    }
    return this;
  }
}
