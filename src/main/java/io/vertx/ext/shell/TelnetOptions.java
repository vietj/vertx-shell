package io.vertx.ext.shell;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.JksOptions;
import io.vertx.core.net.NetServerOptions;
import io.vertx.core.net.PemKeyCertOptions;
import io.vertx.core.net.PemTrustOptions;
import io.vertx.core.net.PfxOptions;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@DataObject
public class TelnetOptions extends NetServerOptions implements ConnectorOptions {

  public TelnetOptions() {
  }

  public TelnetOptions(TelnetOptions other) {
    super(other);
  }

  public TelnetOptions(JsonObject json) {
    super(json);
  }

  @Override
  public TelnetOptions setSendBufferSize(int sendBufferSize) {
    return (TelnetOptions) super.setSendBufferSize(sendBufferSize);
  }

  @Override
  public TelnetOptions setReceiveBufferSize(int receiveBufferSize) {
    return (TelnetOptions) super.setReceiveBufferSize(receiveBufferSize);
  }

  @Override
  public TelnetOptions setReuseAddress(boolean reuseAddress) {
    return (TelnetOptions) super.setReuseAddress(reuseAddress);
  }

  @Override
  public TelnetOptions setTrafficClass(int trafficClass) {
    return (TelnetOptions) super.setTrafficClass(trafficClass);
  }

  @Override
  public TelnetOptions setTcpNoDelay(boolean tcpNoDelay) {
    return (TelnetOptions) super.setTcpNoDelay(tcpNoDelay);
  }

  @Override
  public TelnetOptions setTcpKeepAlive(boolean tcpKeepAlive) {
    return (TelnetOptions) super.setTcpKeepAlive(tcpKeepAlive);
  }

  @Override
  public TelnetOptions setSoLinger(int soLinger) {
    return (TelnetOptions) super.setSoLinger(soLinger);
  }

  @Override
  public TelnetOptions setUsePooledBuffers(boolean usePooledBuffers) {
    return (TelnetOptions) super.setUsePooledBuffers(usePooledBuffers);
  }

  @Override
  public TelnetOptions setIdleTimeout(int idleTimeout) {
    return (TelnetOptions) super.setIdleTimeout(idleTimeout);
  }

  @Override
  public TelnetOptions setSsl(boolean ssl) {
    return (TelnetOptions) super.setSsl(ssl);
  }

  @Override
  public TelnetOptions setKeyStoreOptions(JksOptions options) {
    return (TelnetOptions) super.setKeyStoreOptions(options);
  }

  @Override
  public TelnetOptions setPfxKeyCertOptions(PfxOptions options) {
    return (TelnetOptions) super.setPfxKeyCertOptions(options);
  }

  @Override
  public TelnetOptions setPemKeyCertOptions(PemKeyCertOptions options) {
    return (TelnetOptions) super.setPemKeyCertOptions(options);
  }

  @Override
  public TelnetOptions setTrustStoreOptions(JksOptions options) {
    return (TelnetOptions) super.setTrustStoreOptions(options);
  }

  @Override
  public TelnetOptions setPfxTrustOptions(PfxOptions options) {
    return (TelnetOptions) super.setPfxTrustOptions(options);
  }

  @Override
  public TelnetOptions setPemTrustOptions(PemTrustOptions options) {
    return (TelnetOptions) super.setPemTrustOptions(options);
  }

  @Override
  public TelnetOptions addEnabledCipherSuite(String suite) {
    return (TelnetOptions) super.addEnabledCipherSuite(suite);
  }

  @Override
  public TelnetOptions addCrlPath(String crlPath) throws NullPointerException {
    return (TelnetOptions) super.addCrlPath(crlPath);
  }

  @Override
  public TelnetOptions addCrlValue(Buffer crlValue) throws NullPointerException {
    return (TelnetOptions) super.addCrlValue(crlValue);
  }

  @Override
  public TelnetOptions setAcceptBacklog(int acceptBacklog) {
    return (TelnetOptions) super.setAcceptBacklog(acceptBacklog);
  }

  @Override
  public TelnetOptions setHost(String host) {
    return (TelnetOptions) super.setHost(host);
  }

  @Override
  public TelnetOptions setPort(int port) {
    return (TelnetOptions) super.setPort(port);
  }

  @Override
  public TelnetOptions setClientAuthRequired(boolean clientAuthRequired) {
    return (TelnetOptions) super.setClientAuthRequired(clientAuthRequired);
  }
}