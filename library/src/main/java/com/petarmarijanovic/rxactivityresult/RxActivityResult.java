package com.petarmarijanovic.rxactivityresult;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import io.reactivex.Single;

/** Created by petar on 26/07/2017. */
public class RxActivityResult {

  public static final String FRAGMENT_TAG =
      "com.petarmarijanovic.rxactivityresult.RxActivityResultFragment";

  private RxActivityResultFragment fragment;

  /** TODO: Write JavaDoc. */
  public RxActivityResult(@NonNull FragmentActivity activity) {
    FragmentManager manager = activity.getSupportFragmentManager();

    RxActivityResultFragment attachedFragment =
        (RxActivityResultFragment) manager.findFragmentByTag(FRAGMENT_TAG);

    if (attachedFragment == null) {
      attachedFragment = new RxActivityResultFragment();
      manager.beginTransaction().add(attachedFragment, FRAGMENT_TAG).commitAllowingStateLoss();
      manager.executePendingTransactions();
    }

    this.fragment = attachedFragment;
  }

  /** TODO: Write JavaDoc. */
  public Single<ActivityResult> start(final Intent intent) {
    return fragment.start(intent);
  }

  /** TODO: Write JavaDoc. */
  public Single<ActivityResult> start(final PendingIntent pendingIntent) {
    return fragment.start(pendingIntent);
  }
  
  public Single<ActivityResult> start(int requestCode) {
    return fragment.start(requestCode);
  }  
}
