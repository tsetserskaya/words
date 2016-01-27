/**
 * Copyright (C) dbychkov.com.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dbychkov.words.fragment;

import android.app.Fragment;
import android.os.Bundle;

import butterknife.BindString;

import com.dbychkov.domain.Lesson;
import com.dbychkov.words.R;
import com.dbychkov.words.adapter.BookmarkedLessonsAdapter;
import com.dbychkov.words.adapter.LessonsAdapter;
import com.dbychkov.words.dagger.component.ActivityComponent;
import com.dbychkov.words.presentation.BookmarkedLessonsTabFragmentPresenter;
import com.dbychkov.words.presentation.LessonsPresenter;
import com.dbychkov.words.view.RenderLessonsView;

import javax.inject.Inject;

/**
 * Fragment responsible for rendering lesson list which have been bookmarked
 */
public class BookmarkedLessonsTabFragment extends LessonsTabFragment implements RenderLessonsView {

    @BindString( R.string.noBookmarkedLessons) String emptyMessage;

    @Inject
    BookmarkedLessonsTabFragmentPresenter bookmarkedLessonsTabFragmentPresenter;
    @Inject
    BookmarkedLessonsAdapter bookmarkedLessonsAdapter;

    public static Fragment newInstance() {
        return new BookmarkedLessonsTabFragment();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bookmarkedLessonsTabFragmentPresenter.setView(this);
    }

    @Override
    public void injectActivity(ActivityComponent component) {
        component.inject(this);
    }

    @Override
    public LessonsAdapter getLessonsAdapter() {
        return bookmarkedLessonsAdapter;
    }

    @Override
    public LessonsPresenter getLessonsPresenter() {
        return bookmarkedLessonsTabFragmentPresenter;
    }

    @Override
    public String getEmptyMessage() {
        return emptyMessage;
    }

    @Override
    public void renderCreatedLesson(Lesson lesson) {
        throw new UnsupportedOperationException();
    }
}