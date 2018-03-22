export class UsuarioDto {
    
    login: string;
    senha: string;

    constructor(login: string = null,
                senha: string = null){
        this.login = login;
        this.senha = senha;
    }
}