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

package io.vertx.rxjava.ext.shell.command;

import java.util.Map;
import io.vertx.lang.rxjava.InternalHelper;
import rx.Observable;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.shell.command.BaseCommands original} non RX-ified interface using Vert.x codegen.
 */

public class BaseCommands {

  final io.vertx.ext.shell.command.BaseCommands delegate;

  public BaseCommands(io.vertx.ext.shell.command.BaseCommands delegate) {
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  public static Command ls() { 
    Command ret= Command.newInstance(io.vertx.ext.shell.command.BaseCommands.ls());
    return ret;
  }

  public static Command sleep() { 
    Command ret= Command.newInstance(io.vertx.ext.shell.command.BaseCommands.sleep());
    return ret;
  }

  public static Command echo() { 
    Command ret= Command.newInstance(io.vertx.ext.shell.command.BaseCommands.echo());
    return ret;
  }


  public static BaseCommands newInstance(io.vertx.ext.shell.command.BaseCommands arg) {
    return arg != null ? new BaseCommands(arg) : null;
  }
}