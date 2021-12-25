package com.baseproject.ui.fragment.user_list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.baseproject.data.local.table.UserEntity;
import com.baseproject.data.remote.model.Resource;
import com.baseproject.data.remote.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * Article List view model
 */

@HiltViewModel
public class UserListViewModel extends ViewModel {
    private final LiveData<Resource<List<UserEntity>>> popularArticles;

    @Inject
    public UserListViewModel(UserRepository userRepository) {
        popularArticles = userRepository.loadUsers(0);
    }

    public LiveData<Resource<List<UserEntity>>> getUsers() {
        return popularArticles;
    }
}
