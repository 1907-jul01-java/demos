# Git
Git is a source code management system that can save snapshots of your project on one or more branching paths.

## Glossary
- **Repository**: Files, folders, objects, and branches representing a project, managed within a `.git` folder
- **Working Directory**: Currently active project files and folders.
- **Staging Area**: Area between Working Directory and Repository where project changes are added before the next commit.
- **Commit**: Snapshot of staged changes from a working directory.
- **Branch**: Named pointer to a commit in git history.
- **Head**: Special pointer to the current branch.
- **Remote**: Link to synchronized external repository, usually on a service like GitHub.
- **.gitignore**: Text file listing what to ignore when moving working directory files into staging.

## Flow
After a project is initialized, it moves between uncommitted, staged, and committed phases.

```bash
# Initialize a git project
git init

# Add all new and modified changes to staging
git add .

# Commit staged changes
git commit -m "a commit message"
```

## Remote Repositories
Cloud services like GitHub, GitLab, and BitBucket host git servers which can be synchronized with local repositories. When an existing project on these services is cloned, its `.git` directory will include a remote link to the original project, commonly known as `origin`.

A local repository can also be synchronized in the opposite direction, copying a local project to an empty repository on a cloud server.

```bash
# Create remote link named 'origin'
git remote add origin [git-service-repository-url]

# Push local master branch to origin master branch
git push -u origin master
```