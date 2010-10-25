/*
 * Copyright 2010 The Rabbit Eclipse Plug-in Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package rabbit.data.access.model;


import org.joda.time.Duration;
import org.joda.time.LocalDate;

/**
 * Contains session data information.
 */
public interface ISessionData extends IData {

  /**
   * Key for the date.
   */
  static final IKey<LocalDate> DATE = Key.create();
  
  /**
   * Key for the workspace.
   */
  static final IKey<WorkspaceStorage> WORKSPACE = Key.create();
  
  /**
   * Key for the duration.
   */
  static final IKey<Duration> DURATION = Key.create();
}