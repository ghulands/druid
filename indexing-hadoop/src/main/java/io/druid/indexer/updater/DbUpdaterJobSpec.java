/*
 * Druid - a distributed column store.
 * Copyright 2012 - 2015 Metamarkets Group Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.druid.indexer.updater;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Supplier;
import io.druid.db.DbConnectorConfig;

/**
 */
public class DbUpdaterJobSpec implements Supplier<DbConnectorConfig>
{
  @JsonProperty("connectURI")
  public String connectURI;

  @JsonProperty("user")
  public String user;

  @JsonProperty("password")
  public String password;

  @JsonProperty("segmentTable")
  public String segmentTable;

  public String getSegmentTable()
  {
    return segmentTable;
  }

  @Override
  public DbConnectorConfig get()
  {
    return new DbConnectorConfig()
    {
      @Override
      public String getConnectURI()
      {
        return connectURI;
      }

      @Override
      public String getUser()
      {
        return user;
      }

      @Override
      public String getPassword()
      {
        return password;
      }
    };
  }
}