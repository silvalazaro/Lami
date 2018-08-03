<template>
<v-app>
    <v-navigation-drawer 
    persistent 
    :mini-variant="miniVariant"
     :clipped="clipped"
      v-model="drawer"
       enable-resize-watcher 
       fixed
        app
        class="lighten-3"
    >
        <v-list dense>
            <v-list-tile
                v-if="dashboard"
                @click="$router.push('dashboard')"
            >
                <v-list-tile-action>
                    <v-icon>fas fa-chart-pie</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>Dashboard</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-group v-for="modulo in modulos" 
                :key="modulo.id"
                :prepend-icon="modulo.icon"
                value="true"
                no-action
            >
                <v-list-tile slot="activator" >
                    <v-list-tile-content>
                        <v-list-tile-title>{{modulo.nome}}</v-list-tile-title>
                    </v-list-tile-content>
                </v-list-tile>
                <!-- submenu-->
                <v-list-tile
                    v-for="funcao in modulo.funcoes"
                    :key="funcao.id"
                    @click="$router.push(funcao.link)"
                >
                    <v-list-tile-content>
                        <v-list-tile-title>{{ funcao.nome }}</v-list-tile-title>
                    </v-list-tile-content>
                </v-list-tile>
            </v-list-group>
        </v-list>
    </v-navigation-drawer>
    <v-toolbar app :clipped-left="clipped">
        <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
        <v-spacer></v-spacer>
    </v-toolbar>
    <v-content fluid>
            <router-view></router-view>
    </v-content>
</v-app>
</template>

<script>

export default {
    name: "App",
    data() {
        return {
            clipped: false,
            drawer: true,
            fixed: false,
            dashboard: true,
            modulos: [{
                    id: 1,
                    nome: "Cadastro",
                    icon: "fas fa-search",
                    funcoes:[{
                        id: 1,
                        nome: "Usuários",
                        icon: "fas fa-user",
                        link: "usuario"
                    }, {
                        id: 2,
                        nome: "Pessoas Físicas",
                        icon: "fas fa-user",
                        link: "pessoaFisica"
                    }]
                },
                {
                    id: 2,
                    nome: "Estoque",
                    icon: "fas fa-user"
                },
                {
                    id: 3,
                    nome: "Comercial",
                    icon: "fas fa-user",
                     funcoes:[{
                        id: 1,
                        nome: "Usuários",
                        icon: "fas fa-user"
                    }, {
                        id: 2,
                        nome: "Pessoas Físicas",
                        icon: "fas fa-user"
                    }]
                }
            ],
            miniVariant: false,
            right: true,
            rightDrawer: false
        };
    } 
};
</script>
