/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.olingo.client.core.data;

import java.io.Serializable;
import java.net.URI;
import org.apache.olingo.client.api.data.Operation;

/**
 * Representation of an OData operation (legacy, action or function).
 */
public class OperationImpl extends AbstractPayloadObject implements Operation, Serializable {

  private static final long serialVersionUID = -5784652334334645128L;

  private String metadataAnchor;

  private String title;

  private URI target;

  /**
   * Gets metadata anchor.
   *
   * @return metadata anchor.
   */
  @Override
  public String getMetadataAnchor() {
    return metadataAnchor;
  }

  /**
   * Sets metadata anchor.
   *
   * @param metadataAnchor metadata anchor.
   */
  @Override
  public void setMetadataAnchor(final String metadataAnchor) {
    this.metadataAnchor = metadataAnchor;
  }

  /**
   * Gets title.
   *
   * @return title.
   */
  @Override
  public String getTitle() {
    return title;
  }

  /**
   * Sets title.
   *
   * @param title title.
   */
  @Override
  public void setTitle(final String title) {
    this.title = title;
  }

  /**
   * Gets target.
   *
   * @return target.
   */
  @Override
  public URI getTarget() {
    return target;
  }

  /**
   * Sets target.
   *
   * @param target target.
   */
  @Override
  public void setTarget(final URI target) {
    this.target = target;
  }
}
