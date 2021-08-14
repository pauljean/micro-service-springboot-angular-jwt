curl -X PUT "localhost:9200/customer/_doc/1?pretty" -H 'Content-Type: application/json' -d'
{
  "name": "John Doe"
}
'
kubeadm join 10.209.54.234:6443 --token f65lzh.eoa42cshy2hvijuf \
    --discovery-token-ca-cert-hash sha256:906adc8987d39f84c3298985c2a3c79546ef95606bd86ebd4f10d19107ac1327
	
	kubeadm init --pod-network-cidr=10.209.54.0/16

kubectl apply -f https://raw.githubusercontent.com/coreos/flannel/master/Documentation/kube-flannel.yml

kubeadm join 10.209.54.234:6443 --token sv7i7h.p83k66qq8audojb7 \
    --discovery-token-ca-cert-hash sha256:a7d719b0b7ca766c46efbae33d9bb880d755ba90f30d51dd0a85033eca5a5bce



#kubectl apply -f https://raw.githubusercontent.com/coreos/flannel/master/Documentation/kube-flannel.yml


FLANNEL_NETWORK=10.209.54.0/16
FLANNEL_SUBNET=10.209.0.1/24
FLANNEL_MTU=1450
FLANNEL_IPMASQ=true



10.209.54.23     Ubuntu 20.04 LTS
                                          172.17.0.1
node1                   Running           10.209.54.147    Ubuntu 20.04 LTS
                                          172.17.0.1
                                          10.244.0.1
node2                   Running           10.209.54.93     Ubuntu 20.04 LTS
                                          172.17.0.1
                                          10.244.0.1
node3                   Running           10.209.54.200    Ubuntu 20.04 LTS
                                          172.17.0.1
                                          10.244.0.1
										  
										  
										  ufw allow 81/tcp
