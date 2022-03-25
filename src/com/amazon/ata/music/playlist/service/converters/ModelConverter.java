package com.amazon.ata.music.playlist.service.converters;

import com.amazon.ata.music.playlist.service.models.PlaylistModel;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModelConverter {
    /**
     * Converts a provided {@link Playlist} into a {@link PlaylistModel} representation.
     * @param playlist the playlist to convert
     * @return the converted playlist
     */
    ArrayList<String> tags1 = new ArrayList<>();



    public PlaylistModel toPlaylistModel(Playlist playlist) {
        //im confused about how the set to ArrayList works
        return PlaylistModel.builder()
                .withId(playlist.getId())
                .withCustomerId(playlist.getCustomerId())
                .withName(playlist.getName())
                .withSongCount(playlist.getSongCount())
                .withTags(tags1)

            .build();
    }
}
