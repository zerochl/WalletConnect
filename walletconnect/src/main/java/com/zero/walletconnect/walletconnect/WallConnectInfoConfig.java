package com.zero.walletconnect.walletconnect;

import com.zero.walletconnect.walletconnect.log.LogCallBack;

public class WallConnectInfoConfig {
    private String ethAddress;
    private String url;
    private String name;
    private String description;
    private String icon;
    private String clientId;
    private LogCallBack logCallBack;
    private WalletConnectCallBack walletConnectCallBack;

    public WalletConnectCallBack getWalletConnectCallBack() {
        return walletConnectCallBack;
    }

    public WallConnectInfoConfig setWalletConnectCallBack(WalletConnectCallBack walletConnectCallBack) {
        this.walletConnectCallBack = walletConnectCallBack;
        return this;
    }

    public String getEthAddress() {
        return ethAddress;
    }

    public WallConnectInfoConfig setEthAddress(String ethAddress) {
        this.ethAddress = ethAddress;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public WallConnectInfoConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public WallConnectInfoConfig setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public WallConnectInfoConfig setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public WallConnectInfoConfig setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getClientId() {
        return clientId;
    }

    public WallConnectInfoConfig setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public LogCallBack getLogCallBack() {
        return logCallBack;
    }

    public WallConnectInfoConfig setLogCallBack(LogCallBack logCallBack) {
        this.logCallBack = logCallBack;
        return this;
    }
}
