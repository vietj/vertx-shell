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

package io.vertx.groovy.ext.shell.command.metrics;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.groovy.ext.shell.command.Command
/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
*/
@CompileStatic
public class MetricsCommand {
  private final def io.vertx.ext.shell.command.metrics.MetricsCommand delegate;
  public MetricsCommand(Object delegate) {
    this.delegate = (io.vertx.ext.shell.command.metrics.MetricsCommand) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public static Command ls() {
    def ret= InternalHelper.safeCreate(io.vertx.ext.shell.command.metrics.MetricsCommand.ls(), io.vertx.groovy.ext.shell.command.Command.class);
    return ret;
  }
  public static Command info() {
    def ret= InternalHelper.safeCreate(io.vertx.ext.shell.command.metrics.MetricsCommand.info(), io.vertx.groovy.ext.shell.command.Command.class);
    return ret;
  }
}