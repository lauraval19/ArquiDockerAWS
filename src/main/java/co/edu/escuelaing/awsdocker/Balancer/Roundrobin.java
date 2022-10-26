package co.edu.escuelaing.awsdocker.Balancer;

import co.edu.escuelaing.awsdocker.Balancer.LoadBalancer;

import java.util.List;
import java.util.Random;

public class Roundrobin extends LoadBalancer {

    public Roundrobin(List<String> listaip) {
        super(listaip);
    }

    @Override
    public String getIp(){
        Random rand = new Random();
        return listip.get(rand.nextInt(listip.size()));
    }
}
