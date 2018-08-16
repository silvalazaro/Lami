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
            model: 'Usuario'
        }
    },
    computed: {
        fields(){
            return this.$store.getters[this.$data.model + '/fields'];
        }
    },
    methods:{
        colunas(){
            var ref, colunasTpl = '', colunaTpl;
            for(ref in this.fields){
                if(colunaTpl = this.coluna(this.fields[ref]) || null){
                    console.log(colunaTpl);
                    colunasTpl += colunasTpl;
                }
            }
            return this.fields;
        },
        coluna(field){
            switch(field.type){
                case 'int':
                    break;
                default: 
            }
        }
      
    },
    created(){
   
    }
}
</script>
