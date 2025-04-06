# 📱 LynxApp

LynxApp é um projeto básico desenvolvido para validar a disciplina de **Desenvolvimento para Dispositivos Móveis**.  
O objetivo principal é gerenciar **alunos** e **disciplinas**, permitindo cadastrá-los, editá-los e excluí-los, tudo com dados armazenados em memória.

![GitHub repo](https://img.shields.io/badge/Status-Concluído-green)

---

## 🚀 Funcionalidades

- Tela de **menu** para navegação entre alunos e disciplinas.
- **Listagem** de alunos e disciplinas com botões de ação.
- **Formulários** para cadastro e edição.
- Seleção de disciplinas via **checkbox** ao cadastrar um aluno.
- Validações de confirmação, edição e exclusão.
- Interface criada 100% com **Jetpack Compose**.

---

## 🛠 Tecnologias utilizadas

- **Kotlin**
- **Jetpack Compose**
- **Navigation Compose**
- **Hilt (Dagger Hilt)**
- **Arquitetura MVVM**
- **Injeção de Dependência com Hilt**
- **UI Declarativa e Reativa**

---

## 🧠 Arquitetura

```
├── data/
│   ├── model/            # Modelos de dados (Student, Subject)
│   └── repository/       # Repositórios em memória
│
├── di/
│   └── AppModule.kt      # Injeção de dependência com Hilt
│
├── presentation/
│   ├── navigation/       # Navegação com Navigation Compose
│   ├── components/       # Componentes reutilizáveis (como o Scaffold)
│   └── ui/
│       ├── menu/         # Tela inicial com navegação
│       ├── students/     # Listagem, formulário e ViewModel dos alunos
│       └── subjects/     # Listagem, formulário e ViewModel das disciplinas
│
├── LynxApplication.kt    # Inicialização do Hilt
└── MainActivity.kt       # Inicialização do App
```

---

### 📷 UI

| Início | Alunos | Disciplinas |
|---|---|---|
| <img src="https://github.com/user-attachments/assets/84950dc6-482e-4798-9ca4-09b724c49234" width="250"/> | <img src="https://github.com/user-attachments/assets/8ef7786f-780e-4fff-a47d-aafc06e929ff" width="250"/> | <img src="https://github.com/user-attachments/assets/1b29ec51-5a7c-493c-bda9-326478929d1c" width="250"/> |

| Aluno | Disciplina |
|---|---|
| <img src="https://github.com/user-attachments/assets/cb52cd89-1334-4c68-a920-ebab3c71373f" width="250"/> | <img src="https://github.com/user-attachments/assets/0ea614a0-d340-47d3-9a72-482de23ac43c" width="250"/> |

## 📂 Como rodar o projeto
1. Clone o repositório ``` git clone https://github.com/Luisgmr/lynx-app ```
2. Abra no Android Studio.
3. Aguarde o Gradle sincronizar.
4. Execute em um emulador ou dispositivo Android real.
