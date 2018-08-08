<template>
    <div>
        <v-btn small>
            Criar
        </v-btn>
    </div>
</template>
<script>
export default { 
    name: 'Lista',
    data(){
        return{
            model: 'cadastro/Usuario'
        }
    },
    methods:{
        coluna(field){
        //   console.log(this.$store.getters[this.model+'/fields'])
        console.log('coluna');
        }
      
    },
    created(){
        this.colunas();
    }
}
</script>
