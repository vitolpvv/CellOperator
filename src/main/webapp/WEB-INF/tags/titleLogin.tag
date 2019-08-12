<%@tag description="Simple Title and Login button panel" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true"%>
<div class="d-flex">
    <span class="navbar-text">${title}</span>
</div>
<div class="d-flex dropdown">
    <button class="btn btn-outline-light dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Войти</button>
    <div class="dropdown-menu dropdown-menu-right">
        <form class="form m-2">
            <div class="form-group">
                <label class="sr-only" for="login">Логин</label>
                <input type="text" required class="form-control" id="login" placeholder="Логин">
            </div>
            <div class="form-group">
                <label class="sr-only" for="password">Пароль</label>
                <input type="password" required class="form-control" id="password" placeholder="Пароль">
            </div>
            <button type="submit" class="btn btn-success btn-block">Войти</button>
        </form>
    </div>
</div>