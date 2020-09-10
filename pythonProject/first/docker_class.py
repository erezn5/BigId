import docker
import time


class DockerClass:

    def __init__(self, repo):
        self.client = docker.from_env()
        self.client.login(username='dockerfhy2uuj', password='82vajHSOBk65')
        self.repo = repo

    def stop_container(self):
        for container in self.client.containers.list():
            container.stop()
            print(container.id)
            time.sleep(2)

    def delete_container(self):
        self.client.containers.prune()

    def pull_docker_image(self, image):
        return self.client.images.pull(image)

    def run_container(self, img):
        container = self.client.containers.run(img, detach=True, ports={'80/tcp': 8080})
        time.sleep(2)
        return container.id

    def push_docker_image(self, tag):
        self.client.images.push(self.repo, tag)

    def tag_image(self, image, tag_name):
        image.tag(self.repo, tag_name)
