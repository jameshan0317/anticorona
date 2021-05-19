
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import VaccineManager from "./components/VaccineManager"

import BookingManager from "./components/BookingManager"


import Mypage from "./components/mypage"
import InjectionManager from "./components/InjectionManager"
import CancellationManager from "./components/CancellationManager"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/Vaccine',
                name: 'VaccineManager',
                component: VaccineManager
            },

            {
                path: '/Booking',
                name: 'BookingManager',
                component: BookingManager
            },


            {
                path: '/mypage',
                name: 'mypage',
                component: mypage
            },
            {
                path: '/Injection',
                name: 'InjectionManager',
                component: InjectionManager
            },
            {
                path: '/Cancellation',
                name: 'CancellationManager',
                component: CancellationManager
            },



    ]
})
