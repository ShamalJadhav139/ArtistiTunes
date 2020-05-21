package co.artist.info.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

class ArtistiTunesResponse(
    val resultCount: Int,
    val results: List<Projects>
) : Serializable {
    @Entity(tableName = "project")
    class Projects(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Int = 0,
        @ColumnInfo(name = "artistId")
        val artistId: Int,
        @ColumnInfo(name = "artistName")
        val artistName: String?,
        @ColumnInfo(name = "artistViewUrl", defaultValue = "")
        val artistViewUrl: String?,
        @ColumnInfo(name = "artworkUrl100", defaultValue = "")
        val artworkUrl100: String?,
        @ColumnInfo(name = "artworkUrl30", defaultValue = "")
        val artworkUrl30: String?,
        @ColumnInfo(name = "artworkUrl60", defaultValue = "")
        val artworkUrl60: String?,
        @ColumnInfo(name = "collectionArtistId")
        val collectionArtistId: Int,
        /*@ColumnInfo(name = "collectionArtistName", defaultValue = "")
        val collectionArtistName: String,*/
        @ColumnInfo(name = "collectionArtistViewUrl", defaultValue = "")
        val collectionArtistViewUrl: String?,
        @ColumnInfo(name = "collectionCensoredName", defaultValue = "")
        val collectionCensoredName: String?,
        @ColumnInfo(name = "collectionExplicitness", defaultValue = "")
        val collectionExplicitness: String?,
        @ColumnInfo(name = "collectionId")
        val collectionId: Int,
        @ColumnInfo(name = "collectionName", defaultValue = "")
        val collectionName: String?,
        @ColumnInfo(name = "collectionPrice")
        val collectionPrice: Double,
        @ColumnInfo(name = "collectionViewUrl", defaultValue = "")
        val collectionViewUrl: String?,
        @ColumnInfo(name = "contentAdvisoryRating", defaultValue = "")
        val contentAdvisoryRating: String?,
        @ColumnInfo(name = "country")
        val country: String?,
        @ColumnInfo(name = "currency")
        val currency: String?,
        @ColumnInfo(name = "discCount")
        val discCount: Int,
        @ColumnInfo(name = "discNumber")
        val discNumber: Int,
        @ColumnInfo(name = "isStreamable")
        val isStreamable: Boolean,
        @ColumnInfo(name = "kind")
        val kind: String?,
        @ColumnInfo(name = "previewUrl")
        val previewUrl: String?,
        @ColumnInfo(name = "primaryGenreName")
        val primaryGenreName: String?,
        @ColumnInfo(name = "releaseDate")
        val releaseDate: String?,
        @ColumnInfo(name = "trackCensoredName")
        val trackCensoredName: String?,
        @ColumnInfo(name = "trackCount")
        val trackCount: Int,
        @ColumnInfo(name = "trackExplicitness")
        val trackExplicitness: String?,
        @ColumnInfo(name = "trackId")
        val trackId: Int,
        @ColumnInfo(name = "trackName")
        val trackName: String?,
        @ColumnInfo(name = "trackNumber")
        val trackNumber: Int,
        @ColumnInfo(name = "trackPrice")
        val trackPrice: Double,
        @ColumnInfo(name = "trackTimeMillis")
        val trackTimeMillis: Int,
        @ColumnInfo(name = "trackViewUrl")
        val trackViewUrl: String?,
        @ColumnInfo(name = "wrapperType")
        val wrapperType: String?
    ): Serializable
}