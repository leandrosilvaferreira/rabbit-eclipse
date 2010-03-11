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
package rabbit.core.internal.trackers;

import java.util.Calendar;

import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPart;

import rabbit.core.RabbitCore;
import rabbit.core.events.PartEvent;
import rabbit.core.storage.IStorer;

/**
 * Tracks workbench part usage.
 */
public class PartTracker extends AbstractPartTracker<PartEvent>
		implements IPartListener, IWindowListener {

	public PartTracker() {
		super();
	}

	@Override
	protected IStorer<PartEvent> createDataStorer() {
		return RabbitCore.getStorer(PartEvent.class);
	}

	@Override
	protected PartEvent tryCreateEvent(Calendar time, long duration, IWorkbenchPart p) {
		return new PartEvent(time, duration, p);
	}

}
