/**
 * Copyright (c) 2010-2023 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.myuplink.internal.command.account;

import static org.openhab.binding.myuplink.internal.MyUplinkBindingConstants.*;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.http.HttpMethod;
import org.openhab.binding.myuplink.internal.command.AbstractCommand;
import org.openhab.binding.myuplink.internal.command.JsonResultProcessor;
import org.openhab.binding.myuplink.internal.handler.MyUplinkBridgeHandler;

/**
 * implements the get sites api call of the site.
 *
 * @author Alexander Friese - initial contribution
 */
@NonNullByDefault
public class GetSystems extends AbstractCommand {

    public GetSystems(MyUplinkBridgeHandler handler, JsonResultProcessor resultProcessor) {
        // retry does not make much sense as it is a polling command, command should always succeed therefore update
        // handler on failure.
        super(handler, RetryOnFailure.NO, ProcessFailureResponse.YES, resultProcessor);
    }

    @Override
    protected Request prepareRequest(Request requestToPrepare) {
        requestToPrepare.method(HttpMethod.GET);
        return requestToPrepare;
    }

    @Override
    protected String getURL() {
        String url = GET_SYSTEMS_URL;
        return url;
    }

    @Override
    protected String getChannelGroup() {
        return CHANNEL_GROUP_NONE;
    }
}
