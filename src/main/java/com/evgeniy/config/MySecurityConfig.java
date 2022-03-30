package com.evgeniy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

// Отвечает за конфигурацию нашего security
// Здесь мы настраиваем роли, пароли и тд.
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Указываем конфигу security что информация о наших юзерах содержит БД
        // И указываем dataSource который содержит инфу о подключении к БД
        // И так как мы создали в бд определённые таблицы и с определёнными колонками,
        // spring-secutiry сам будет проверять все данные
        // Если мы делаем свои таблицы или формы то и логику сравнения нужно писать самим
        auth.jdbcAuthentication().dataSource(dataSource);

        /* Шифрование bcrypt - bcrypt(текстовый пароль + соль) = шифрованный пароль.
         Соль всегда меняется.
         Spring читает юзера, находит его в БД, смотрит на шифрование его пароля,
         видит что шифрование bcrypt, берёт из зашифрованного пароля часть которая отвечает за соль,
         соединяет эту соль с введённым паролем и производит bcrypt шифрование, и получается шифрованный пароль,
         который сравнивается с паролем в БД. Если пароли совпадают, то разрешается вход в систему. */

        // Создание юзеров в памяти
        /*UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("evgeniy")
                        .password("evgeniy")
                        .roles("EMPLOYEE"))
                .withUser(userBuilder.username("nina")
                        .password("nina")
                        .roles("HR"))
                .withUser(userBuilder.username("ivan")
                        .password("ivan")
                        .roles("MANAGER", "HR"));*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                .antMatchers("/hr-info").hasRole("HR")
                .antMatchers("/manager-info").hasRole("MANAGER")
                .and()
                .formLogin().permitAll(); // Форма логина и пароля будет запрашиваться у всех
    }
}
