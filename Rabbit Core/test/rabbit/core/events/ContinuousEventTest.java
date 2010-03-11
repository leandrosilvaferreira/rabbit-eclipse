/*
 * Copyright 2010 The Rabbit Eclipse Plug-in Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rabbit.core.events;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

/**
 * Test for {@link ContinuousEvent}
 */
public class ContinuousEventTest extends DiscreteEventTest {

	private static long duration = 348723;

	private ContinuousEvent event;

	public ContinuousEventTest() {
		event = createEvent(Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_withNegativeDuration() {
		new ContinuousEvent(Calendar.getInstance(), -1);
	}

	@Test
	public void testGetDuration() {
		assertEquals(duration, event.getDuration());
	}

	@Test
	public void testSetDuration() {

		long newDura = 349850;
		event.setDuration(newDura);
		assertEquals(newDura, event.getDuration());

		newDura = 0;
		event.setDuration(newDura);
		assertEquals(newDura, event.getDuration());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetDuration_withNegativeDuration() {
		event.setDuration(-1);
	}

	@Override
	protected ContinuousEvent createEvent(Calendar time) {
		return createEvent(time, duration);
	}

	protected ContinuousEvent createEvent(Calendar time, long duration) {
		return new ContinuousEvent(time, duration);
	}
}