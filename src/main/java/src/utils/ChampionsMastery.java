
package src.utils;

import javax.annotation.processing.Generated;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Generated("net.hexar.json2pojo")
@Data
public class ChampionsMastery {

    @SerializedName("championId")
    private Long mChampionId;
    @SerializedName("championLevel")
    private Long mChampionLevel;
    @SerializedName("championPoints")
    private Long mChampionPoints;
    @SerializedName("championPointsSinceLastLevel")
    private Long mChampionPointsSinceLastLevel;
    @SerializedName("championPointsUntilNextLevel")
    private Long mChampionPointsUntilNextLevel;
    @SerializedName("chestGranted")
    private Boolean mChestGranted;
    @SerializedName("lastPlayTime")
    private Long mLastPlayTime;
    @SerializedName("summonerId")
    private String mSummonerId;
    @SerializedName("tokensEarned")
    private Long mTokensEarned;


}
