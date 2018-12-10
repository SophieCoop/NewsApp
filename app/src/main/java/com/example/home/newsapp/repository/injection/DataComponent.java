package com.example.home.newsapp.repository.injection;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules={DataModule.class})
public interface DataComponent {
}