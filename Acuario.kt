package acuario

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "off"
    open val deviceType = "Unknown"

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"
    var volume = 10
    var channel = 5

    fun decreaseVolume() {
        volume--
        println("Volume decreased to $volume")
    }

    fun previousChannel() {
        channel--
        println("Channel changed to $channel")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"
    var brightness = 50

    fun decreaseBrightness() {
        brightness--
        println("Brightness decreased to $brightness")
    }
}

class SmartHome(val tv: SmartTvDevice, val light: SmartLightDevice) {

    var deviceTurnOnCount = 0

    fun turnOnTv() {
        if (tv.deviceStatus == "off") {
            tv.deviceStatus = "on"
            deviceTurnOnCount++
        }
    }

    fun turnOnLight() {
        if (light.deviceStatus == "off") {
            light.deviceStatus = "on"
            deviceTurnOnCount++
        }
    }

    fun decreaseTvVolume() {
        if (tv.deviceStatus == "on") tv.decreaseVolume()
    }

    fun changeTvChannelToPrevious() {
        if (tv.deviceStatus == "on") tv.previousChannel()
    }

    fun printSmartTvInfo() = tv.printDeviceInfo()

    fun printSmartLightInfo() = light.printDeviceInfo()

    fun decreaseLightBrightness() {
        if (light.deviceStatus == "on") light.decreaseBrightness()
    }
}

fun main() {
    val myTv = SmartTvDevice("Android TV", "Entertainment")
    val myLight = SmartLightDevice("Google Light", "Utility")
    val myHome = SmartHome(myTv, myLight)

    myHome.turnOnTv()
    myHome.turnOnLight()

    myHome.printSmartTvInfo()
    myHome.decreaseTvVolume()
    myHome.changeTvChannelToPrevious()

    myHome.printSmartLightInfo()
    myHome.decreaseLightBrightness()

    println("Total devices on: ${myHome.deviceTurnOnCount}")
}