import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UsuarioDto} from "./usuario-dto.model";

@Injectable()
export class UsuarioService {
  url: string;

  constructor(public httpClient: HttpClient) {
    this.url = 'http://localhost:8081/AppRest/services/usuario/';
  }

  /**
   * Retorna a lista de usuários cadastrados
   * @returns {Observable<Object>}
   */
  listar() {
    return this.httpClient.get(this.url + 'lista');
  }

  /**
   * Busca usuario por número do id.
   * @param id Retorno do método de login.
   * @returns {Observable<Object>}
   */
  buscarComId(id: number) {
    return this.httpClient.get(this.url + 'buscar', id);
  }

  /**
   * Logar no sistema, se for válido retorna id.
   * @param usuarioDto login e senha do usuário
   * @returns {Observable<Object>}
   */
  logar(usuarioDto: UsuarioDto) {
    return this.httpClient.post(this.url + 'logar', usuarioDto);
  }
}
