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
package rabbit.core.storage.xml;

import java.util.Collection;

import rabbit.core.internal.storage.xml.AbstractAccessor;
import rabbit.core.internal.storage.xml.DataStore;
import rabbit.core.internal.storage.xml.IDataStore;
import rabbit.core.internal.storage.xml.schema.events.EventListType;
import rabbit.core.internal.storage.xml.schema.events.PerspectiveEventListType;
import rabbit.core.internal.storage.xml.schema.events.PerspectiveEventType;

public class PerspectiveDataAccessor
		extends AbstractAccessor<PerspectiveEventType, PerspectiveEventListType> {

	@Override
	protected Collection<PerspectiveEventListType> getCategories(EventListType doc) {
		return doc.getPerspectiveEvents();
	}

	@Override
	protected IDataStore getDataStore() {
		return DataStore.PERSPECTIVE_STORE;
	}

	@Override
	protected String getId(PerspectiveEventType e) {
		return e.getPerspectiveId();
	}

	@Override
	protected long getUsage(PerspectiveEventType e) {
		return e.getDuration();
	}

	@Override
	protected Collection<PerspectiveEventType> getXmlTypes(PerspectiveEventListType list) {
		return list.getPerspectiveEvent();
	}

}
