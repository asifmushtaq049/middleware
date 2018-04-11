/*
 * Copyright (c) 2015 AsyncHttpClient Project. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at
 *     http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package climesoft.net.netty.handler.intercept;

import io.netty.channel.Channel;
import climesoft.net.Request;
import climesoft.net.RequestBuilder;
import climesoft.net.netty.NettyResponseFuture;
import climesoft.net.netty.channel.ChannelManager;
import climesoft.net.netty.request.NettyRequestSender;
import climesoft.net.proxy.ProxyServer;
import climesoft.net.uri.Uri;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectSuccessInterceptor {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConnectSuccessInterceptor.class);

  private final ChannelManager channelManager;
  private final NettyRequestSender requestSender;

  ConnectSuccessInterceptor(ChannelManager channelManager, NettyRequestSender requestSender) {
    this.channelManager = channelManager;
    this.requestSender = requestSender;
  }

  public boolean exitAfterHandlingConnect(Channel channel,
                                          NettyResponseFuture<?> future,
                                          Request request,
                                          ProxyServer proxyServer) {

    if (future.isKeepAlive())
      future.attachChannel(channel, true);

    Uri requestUri = request.getUri();
    LOGGER.debug("Connecting to proxy {} for scheme {}", proxyServer, requestUri.getScheme());

    channelManager.updatePipelineForHttpTunneling(channel.pipeline(), requestUri);
    future.setReuseChannel(true);
    future.setConnectAllowed(false);
    requestSender.drainChannelAndExecuteNextRequest(channel, future, new RequestBuilder(future.getTargetRequest()).build());

    return true;
  }
}
