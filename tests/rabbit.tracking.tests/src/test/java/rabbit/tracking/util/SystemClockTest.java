/*
 * Copyright 2012 The Rabbit Eclipse Plug-in Project
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

package rabbit.tracking.util;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.joda.time.Instant.now;
import static org.junit.Assert.assertThat;

import org.joda.time.Instant;
import org.junit.Test;

public final class SystemClockTest {

  @SuppressWarnings("unchecked")//
  @Test public void returnsSystemTime() {
    Instant before = now();
    Instant now = SystemClock.INSTANCE.now();
    Instant after = now();
    assertThat(now.getMillis(),
        allOf(
            greaterThanOrEqualTo(before.getMillis()),
            lessThanOrEqualTo(after.getMillis())));
  }
}
