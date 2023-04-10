package com.kailin.kotlin_app_arch.model

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
 * @param limited_time 有無限時
 * @param socket 插座多
 * @param standing_desk 可站立工作
 * @param city 城市
 * @param mrt 捷運站
 * @param open_time 營業時間
 */
data class CafeNomad(
    val id: String,
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
    val limited_time: String,
    val socket: String,
    val standing_desk: String,
    val city: String,
    val mrt: String,
    val open_time: String,
)