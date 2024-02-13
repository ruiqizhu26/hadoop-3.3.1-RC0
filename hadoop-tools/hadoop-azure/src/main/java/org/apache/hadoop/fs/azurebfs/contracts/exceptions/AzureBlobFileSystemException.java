/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.fs.azurebfs.contracts.exceptions;

import java.io.IOException;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;

/**
 * Base exception for any Azure Blob File System driver exceptions. All the exceptions must inherit this class.
 */
@InterfaceAudience.Public
@InterfaceStability.Evolving
public abstract class AzureBlobFileSystemException extends IOException {
  public AzureBlobFileSystemException(final String message) {
    super(message);
  }

  public AzureBlobFileSystemException(final String message, final Exception innerException) {
    super(message, innerException);
  }

  public AzureBlobFileSystemException(final String message, final Throwable innerThrowable) {
    super(message, innerThrowable);
  }

  @Override
  public String toString() {
    if (this.getMessage() == null && this.getCause() == null) {
      return "AzureBlobFileSystemException";
    }

    if (this.getCause() == null) {
      return this.getMessage();
    }

    if (this.getMessage() == null) {
      return this.getCause().toString();
    }

    return this.getMessage() + this.getCause().toString();
  }
}
