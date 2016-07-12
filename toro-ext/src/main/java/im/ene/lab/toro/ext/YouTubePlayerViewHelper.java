/*
 * Copyright 2016 eneim@Eneim Labs, nam@ene.im
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.ene.lab.toro.ext;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewParent;
import com.google.android.youtube.player.YouTubePlayer;
import im.ene.lab.toro.PlayerViewHelper;
import im.ene.lab.toro.ToroPlayer;
import im.ene.lab.toro.ToroPlayerViewHelper;
import im.ene.lab.toro.media.PlaybackException;

/**
 * Created by eneim on 4/8/16.
 */
public class YouTubePlayerViewHelper extends PlayerViewHelper {

  private final ToroPlayerViewHelper delegate;

  public YouTubePlayerViewHelper(@NonNull ToroPlayer player, @NonNull View itemView) {
    super(player, itemView);
    delegate = new ToroPlayerViewHelper(player, itemView);
  }

  // Adapt from YoutubePlayer
  public void onPlaying() {
  }

  public void onPaused() {
  }

  public void onBuffering(boolean b) {
  }

  public void onSeekTo(int i) {
  }

  public void onLoading() {
  }

  public void onLoaded(String s) {
  }

  public void onAdStarted() {
  }

  public void onVideoStarted(ToroPlayer player) {
    player.onPlaybackStarted();
  }

  public void onVideoEnded(ToroPlayer player) {
    player.onPlaybackCompleted();
  }

  public void onYoutubeError(ToroPlayer player, YouTubePlayer.ErrorReason errorReason) {
    PlaybackException error =
        errorReason != null ? new PlaybackException(errorReason.name(), 0, 0) : null;
    player.onPlaybackError(null, error);
  }

  public void onYoutubePlayerChanged(YouTubePlayer newPlayer) {
    // Do I need to do anything?
  }

  // Adapt from RecyclerViewItemHelper

  @Override public void onAttachedToParent() {
    delegate.onAttachedToParent();
  }

  @Override public void onDetachedFromParent() {
    delegate.onDetachedFromParent();
  }

  @Override public boolean onItemLongClick(@NonNull ToroPlayer player, @NonNull View itemView,
      @Nullable ViewParent parent) {
    return delegate.onItemLongClick(player, itemView, parent);
  }

}