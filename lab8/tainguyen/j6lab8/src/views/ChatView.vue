<template>
    <div>
        <h2>WebSocket Chat</h2>
        <input v-model="username" placeholder="Enter your name" :disabled="connected" />
        <button @click="connect" :disabled="connected">Connect</button>
        <button @click="disconnect" :disabled="!connected">Disconnect</button>
        <br /><br />
        <input v-model="message" placeholder="Enter message" :disabled="!connected" />
        <button @click="sendMessage" :disabled="!connected">Send</button>

        <ul>
            <li v-for="(msg, index) in messages" :key="index">
                <b>{{ msg.sender }}:</b> {{ msg.content }}
            </li>
        </ul>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import SockJS from 'sockjs-client'
import { CompatClient, Stomp } from '@stomp/stompjs'

const stompClient = ref(null)
const connected = ref(false)
const message = ref('')
const username = ref('')
const messages = ref([])

const connect = () => {
    const socket = new SockJS('http://localhost:8080/ws')
    stompClient.value = Stomp.over(socket)
    stompClient.value.connect({}, () => {
        connected.value = true
        stompClient.value.subscribe('/topic/messages', (msg) => {
            const chat = JSON.parse(msg.body)
            messages.value.push(chat)
        })
    })
}

const disconnect = () => {
    if (stompClient.value !== null) {
        stompClient.value.disconnect()
    }
    connected.value = false
}

const sendMessage = () => {
    if (stompClient.value && message.value.trim() !== '') {
        const chatMessage = {
            sender: username.value,
            content: message.value,
            type: 'CHAT'
        }
        stompClient.value.send('/app/chat', {}, JSON.stringify(chatMessage))
        message.value = ''
    }
}
</script>
