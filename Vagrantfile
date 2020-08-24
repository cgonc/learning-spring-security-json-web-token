VAGRANTFILE_API_VERSION = "2"

Vagrant.configure("2") do |config|
  config.vm.box = "ubuntu/xenial64"

  config.vm.provision :docker
  config.vm.provision :docker_compose

  # Start postgres
  config.vm.network "forwarded_port", guest: 5432, host: 5432
  config.vm.provision :docker_compose, rebuild: true, yml: "/vagrant/sde/postgres/docker-compose.yml", run: "always"

   # start rabbitmq
   config.vm.network "forwarded_port", guest: 5672, host: 5672
   config.vm.network "forwarded_port", guest: 15672, host: 15672
   config.vm.provision :docker_compose, rebuild: true, yml: "/vagrant/sde/rabbitmq/docker-compose.yml", run: "always"

   # start redis
   config.vm.network "forwarded_port", guest: 6379, host: 6379
   config.vm.provision :docker_compose, rebuild: true, yml: "/vagrant/sde/redis/docker-compose.yml", run: "always"
end