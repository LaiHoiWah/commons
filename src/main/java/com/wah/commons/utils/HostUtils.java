package com.wah.commons.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HostUtils{

    private static final String REGEX = "((?<scheme>[a-zA-Z]+)://)?((?<username>\\S+):(?<password>\\S+)@)?(?<hostname>[a-zA-Z0-9.]+)(:(?<port>\\d+))?((?<path>[a-zA-Z0-9/_\\.\\-]+))?(\\?(?<params>\\S+))?";

    public static Host getHttpHost(String url){
        Host host = parse(url);

        String scheme = host.getScheme();
        String port   = host.getPort();

        if(StringUtils.isBlank(scheme)){
            host.setScheme("http");
        }

        if(StringUtils.isBlank(port)){
            host.setPort("80");
        }

        return host;
    }

    private static Host parse(String url){
        AssertUtils.hasText(url, "URL信息不能为空");

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(url);

        if(!matcher.matches()){
            throw new IllegalArgumentException("URL信息不正确 : [scheme://]hostname[:port][/path][?params]");
        }

        String scheme   = matcher.group("scheme");
        String hostname = matcher.group("hostname");
        String port     = matcher.group("port");
        String username = matcher.group("username");
        String password = matcher.group("password");
        String path     = matcher.group("path");
        String params   = matcher.group("params");

        return new Host(scheme, hostname, port, username, password, path, params);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Host{

        private String scheme;
        private String hostname;
        private String port;
        private String username;
        private String password;
        private String path;
        private String params;

        public Map<String, String> paramsMap(){
            return ParamsUtils.asMap((this.params));
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();

            if(StringUtils.isNotBlank(this.scheme)){
                sb.append(this.scheme)
                  .append("://");
            }
            if(StringUtils.isNotBlank(this.username) && StringUtils.isNotBlank(this.password)){
                sb.append(this.username)
                  .append(":")
                  .append(this.password)
                  .append("@");
            }
            if(StringUtils.isNotBlank(this.hostname)){
                sb.append(this.hostname);
            }
            if(StringUtils.isNotBlank(this.port)){
                sb.append(":")
                  .append(this.port);
            }
            if(StringUtils.isNotBlank(this.path)){
                sb.append(this.path);
            }
            if(StringUtils.isNotBlank(this.params)){
                sb.append("?")
                  .append(this.params);
            }

            return sb.toString();
        }
    }
}
