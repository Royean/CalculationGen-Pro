/*
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
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.aliyuncs.auth;

import java.util.Map;

import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.MethodType;

public interface ISignatureComposer {

    public Map<String, String> refreshSignParameters(Map<String, String> parameters,
                                                     ISigner signer, String accessKeyId, FormatType format);

    public String composeStringToSign(MethodType method,
                                      String uriPattern, ISigner signer,
                                      Map<String, String> queries,
                                      Map<String, String> headers,
                                      Map<String, String> paths);
}
