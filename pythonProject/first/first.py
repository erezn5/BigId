import logging
import requests
from docker_class import DockerClass
logging.basicConfig(level=logging.INFO, filename='logger.log')

d = DockerClass('dockerfhy2uuj/big_id')
logging.info("Pulling new docker image")
img = d.pull_docker_image('nginx:latest')
logging.info("Running container")
container_id = d.run_container(img)
logging.info("tagging the container image")
d.tag_image(img, 'latest')

r = requests.get('http://localhost:8080')
if r.status_code != 200:
    logging.error("This is not 200")

logging.info("Pushing image to docker hub")
d.push_docker_image('latest')
logging.info("stopping container")
d.stop_container()
logging.info("Deleting container")
d.delete_container()

