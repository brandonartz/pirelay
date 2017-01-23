/**
 *  RaspberryPi Relay - Momentary Button Tile
 *
 *  Author: Brandon Artz
 *
 *  Date: 2017-01-19
 */
metadata {
	definition (name: "Raspberrypi Relay - Momentary Button Tile", namespace: "brandonartz", author: "brandonartz") {
		capability "Actuator"
		capability "Switch"
		capability "Momentary"
		capability "Sensor"
	}

	// simulator metadata
	simulator {
	}

	// UI tile definitions
	tiles {
		standardTile("switch", "device.switch", width: 1, height: 1, canChangeIcon: true) {
			state "off", label: 'Push', action: "momentary.push", backgroundColor: "#ffffff", nextState: "on"
			state "on", label: 'Push', action: "momentary.push", backgroundColor: "#53a7c0"
		}
		main "switch"
		details "switch"
	}
}

def parse(String description) {

}

def push() {
	sendEvent(name: "switch", value: "on", isStateChange: true, displayed: false)
	sendEvent(name: "momentary", value: device.deviceNetworkId, isStateChange: true)
    sendEvent(name: "switch", value: "off", isStateChange: true, displayed: false)
}

def on() {
	push()
}

def off() {
	push()
}