package co.edu.escuelaing.awsdocker.Balancer;

import java.util.List;

public abstract class LoadBalancer {
    final List<String> listip;

    public LoadBalancer(List<String> listaip) {
        this.listip = listaip;
    }
    abstract String getIp();
}
