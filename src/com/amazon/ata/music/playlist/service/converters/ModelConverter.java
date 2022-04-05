package com.amazon.ata.music.playlist.service.converters;

import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.models.PlaylistModel;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.models.SongModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ModelConverter {
    /**
     * Converts a provided {@link Playlist} into a {@link PlaylistModel} representation.
     * @param playlist the playlist to convert
     * @return the converted playlist
     */




    public PlaylistModel toPlaylistModel(Playlist playlist) {
        List<String> tags1 = null;
        if (playlist.getTags() != null) {
            tags1 = new ArrayList<>(playlist.getTags());

        }
        return PlaylistModel.builder()
                .withId(playlist.getId())
                .withCustomerId(playlist.getCustomerId())
                .withName(playlist.getName())
                .withSongCount(playlist.getSongCount())
                .withTags(tags1)
                .build();
    }

    public SongModel toSongModel(AlbumTrack albumTrack) {


        return SongModel.builder()
                .withAsin(albumTrack.getAsin())
                .withAlbum(albumTrack.getAlbumName())
                .withTitle(albumTrack.getSongTitle())
                .withTrackNumber(albumTrack.getTrackNumber())
                .build();
    }

    public List<SongModel> toSongModelList(List<AlbumTrack> albumTracks) {

        List<SongModel> songListConverted = new LinkedList<>();

        for(AlbumTrack albumtrack : albumTracks) {
            SongModel songModel = new ModelConverter().toSongModel(albumtrack);
            songListConverted.add(songModel);
        }
        return songListConverted;
    }
}