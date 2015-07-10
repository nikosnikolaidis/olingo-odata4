/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.olingo.server.core.debug;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.apache.olingo.commons.api.http.HttpStatusCode;
import org.apache.olingo.server.api.ODataResponse;

import com.fasterxml.jackson.core.JsonGenerator;

/**
 * Response debug information.
 */
public class DebugInfoResponse implements DebugInfo {

  private final ODataResponse response;
  private final String serviceRoot;
  private final HttpStatusCode status;
  private final Map<String, String> headers;

  public DebugInfoResponse(final ODataResponse applicationResponse, final String serviceRoot) {
    this.response = applicationResponse;
    this.serviceRoot = serviceRoot;
    status = HttpStatusCode.fromStatusCode(response.getStatusCode());
    headers = response.getHeaders();
  }

  @Override
  public String getName() {
    return "Response";
  }

  @Override
  public void appendJson(final JsonGenerator gen) throws IOException {
    gen.writeStartObject();

    if (status != null) {
      gen.writeFieldName("status");
      gen.writeStartObject();
      gen.writeStringField("code", Integer.toString(status.getStatusCode()));
      gen.writeStringField("info", status.getInfo());
      gen.writeEndObject();
    }

    if (headers != null && !headers.isEmpty()) {
      gen.writeFieldName("headers");
      DebugResponseHelperImpl.appendJsonTable(gen, headers);
    }

    gen.writeFieldName("body");
    new DebugInfoBody(response, serviceRoot).appendJson(gen);

    gen.writeEndObject();
  }

  @Override
  public void appendHtml(final Writer writer) throws IOException {
//    writer.append("<h2>Status Code</h2>\n")
//        .append("<p>").append(Integer.toString(status.getStatusCode())).append(' ')
//        .append(status.getInfo()).append("</p>\n")
//        .append("<h2>Response Headers</h2>\n");
//    ODataDebugResponseWrapper.appendHtmlTable(writer, headers);
//    if (response.getContentHeader() != null && response.getEntity() != null) {
//      writer.append("<h2>Response Body</h2>\n");
//      new DebugInfoBody(response, serviceRoot).appendHtml(writer);
//    }
  }
}
