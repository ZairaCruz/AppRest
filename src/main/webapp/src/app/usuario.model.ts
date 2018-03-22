export class Usuario {
    
    id: number;
    login: string;
    senha: string;

    constructor(id: number = null,
                login: string = null,
                senha: string = null){
        this.id = id;
        this.login = login;
        this.senha = senha;
    }
}