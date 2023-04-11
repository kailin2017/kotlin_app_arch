package tw.idv.kailin.kotlin.cafe.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/***
 * @param id 一組UUID
 * @param name 店名
 * @param wifi wifi 穩定
 * @param seat 通常有位
 * @param quiet 安靜程度
 * @param tasty 咖啡好喝
 * @param cheap 價格便宜
 * @param music 裝潢音樂
 * @param address 地址
 * @param latitude 緯度
 * @param longitude 經度
 * @param url 官網
 * @param limitedTime 有無限時
 * @param socket 插座多
 * @param standingDesk 可站立工作
 * @param city 城市
 * @param mrt 捷運站
 * @param openTime 營業時間
 */
@Entity
data class CafeNomad(
    @PrimaryKey val id: String,
    val name: String,
    val wifi: Double,
    val seat: Double,
    val quiet: Double,
    val tasty: Double,
    val cheap: Double,
    val music: Double,
    val address: String,
    val latitude: String,
    val longitude: String,
    val url: String,
    @ColumnInfo(name = "limited_time") @SerializedName("limited_time") val limitedTime: String,
    val socket: String,
    @ColumnInfo(name = "standing_desk") @SerializedName("standing_desk") val standingDesk: String,
    val city: String,
    val mrt: String,
    @ColumnInfo(name = "open_time") @SerializedName("open_time") val openTime: String,
)