var vueApp = new Vue({
    el: '#app',
    data: {
        message: 'hit "get Data" to retrieve tasks'
    },
    methods: {
        getTasks: function () {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    vueApp.message = this.responseText;
                }
            };
            xhttp.open("GET", "/tasks", true);
            xhttp.send();
        }
    }
})
