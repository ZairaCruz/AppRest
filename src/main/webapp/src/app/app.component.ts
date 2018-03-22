import { UsuarioDto } from './usuario-dto.model';
import { Usuario } from './usuario.model';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Component } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {UsuarioService} from "./usuario.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'app';
  usuario: Usuario = new Usuario();
  usuarioDto: UsuarioDto = new UsuarioDto();
  usuarioLogado = false;
  usuarios: Usuario[] = [];
  url = '';

  constructor(public httpClient: HttpClient,
              public usuarioService: UsuarioService) {
  }

  public listagemUsuarios(): void {
    this.usuarioService.listar().subscribe((lista: Usuario[]) => {
      this.usuarios = lista;
    });
  }

  public loginUsuario(usuarioDto: UsuarioDto): void {
    let id = 0;
    this.usuarioService.logar(usuarioDto).subscribe((resultado: number) => {
      console.log(resultado);
      if (resultado) {
        this.usuarioLogado = true;
        id = resultado;
      }
    });
    this.buscarUsuarioComId(id);
  }

  public buscarUsuarioComId(id: number): Usuario {
    this.usuario = new Usuario();
    this.usuarioService.buscarComId(id).subscribe((usuario: Usuario) => {
      this.usuario = usuario;
    });
    console.log(this.usuario);
    return this.usuario;
  }
}
