# **Git & GitHub**

### **Basics**

- **Git** → Distributed version control system for tracking code changes.
- **GitHub** → Cloud platform for hosting Git repositories and collaborating.
- **Repository (Repo)** → Project tracked by Git; local repo contains a `.git` directory.
- **`.git`** → Hidden folder containing Git’s repository data: commits, branches, configuration, etc.

### **Setup**

- `git --version` → Show installed Git version.
- `git config --global user.name "Name"` → Set Git username globally.
- `git config --global user.email "email"` → Set Git email globally.
- `git config --global user.name` → Read global username.
- `git config --local user.name` → Read repository-specific username; requires being inside a Git repo.
- **Global vs Local** → Global applies by default to all repos for the user; Local applies only to the current repo and overrides global.

### **Initialize Repository**

- `git init` → Initialize current folder as a Git repository by creating `.git`.
- **Branch** → Separate line of development; current branch can be seen with `git status`.

### **Git File States**

- **Untracked** → New file known to exist but not yet tracked by Git.
- **Staged** → Current version selected for the next commit.
- **Committed** → Changes saved as a snapshot in Git history.

**Basic flow:** `Working Directory → git add → Staging Area → git commit → Repository`

### **Staging**

- `git add <file>` → Stage a specific file’s current version.
- `git add .` → Stage all eligible changes in the current directory.
- Running `git add <file>` again after editing updates the staged version.
- Staging is **not version history**; commits create actual history.

### **Status & Differences**

- `git status` → Show current branch, file states, and pending changes.
- `git diff` → Compare **Working Directory vs Staging Area**; shows unstaged changes.
- `git diff --staged` → Compare **Staging Area vs Last Commit**; shows what will be committed.
- `+` in diff → Added line; `-` → Removed line.
- `---` → Old version; `+++` → New version.
- `a/` and `b/` in diff → Labels for old/new sides, not actual project folders.

### **Commit & History**

- `git commit -m "message"` → Create a commit from staged changes.
- `git log` → Show commit history with details.
- `git log --oneline` → Compact commit history.
- **Commit** → Saved snapshot of staged changes with a unique commit hash.
- **HEAD** → Pointer to the current position in Git history, usually the latest commit on the current branch.
- **Root commit** → First commit in a repository.

### **.gitignore**

- **`.gitignore`** → File containing patterns for files/folders Git should ignore.
- `*.file-extension` → Ignore all `.file-extension` files in repo and don't include for commits.
- Ignored files are not shown as normal untracked files by `git status`.
- `.gitignore` itself should usually be tracked and committed.

### **Current Practical Workflow**

```
Create project
↓
git init
↓
Create/modify files
↓
git status
↓
git add <file>
↓
git diff --staged
↓
git commit -m "message"
↓
git log
```

### **git restore**

- `git restore <file>` → Discard **unstaged changes** and restore the file to before change.
- `git restore .` → Discard all unstaged changes in the current directory.
- `git restore --staged <file>` → Unstage a file but **keep its changes** in the Working Directory.
- `git restore --staged .` → Unstage all staged changes in the current directory.
- **Key difference** → `restore` discards Working Directory changes; `restore --staged` only removes changes from the Staging Area.

### **git revert**

- `git revert <commit>` → Create a **new commit** that reverses the changes introduced by an existing commit.
- A commit can itself be reverted → reverting a revert generally **reapplies the original change**.
- **Use case** → Safely undo committed changes while preserving history, especially for shared/pushed commits.
- Git can auto-generate messages like `Revert "commit message"`; reverting a revert may generate `Reapply "commit message"`.

### **git reset**

- **`git reset <commit>`** → Moves `HEAD` to that commit.
- For v2 → x = 20 ; v3 → x = 30; now commits is v1 → v2 → v3 and we did git reset v2.

| Mode | Current | Staged | Commit | Current Head |
| --- | --- | --- | --- | --- |
| `--soft` | `x = 30` | `x = 30` | `x = 20` | `v2` |
| `--mixed` | `x = 30` | `x = 20` | `x = 20` | `v2` |
| `--hard` | `x = 20` | `x = 20` | `x = 20` | `v2` |
- **`--soft`** → working and stage is v3 just commit is v2. **Changes remain staged.**
- **`--mixed`** → working is v3, stage and commit is v2. **Changes become unstaged.** The default one without mention is mixed.
- **`--hard`** → discard every change of v3; current, stage and commit is v2. **Changes are discarded from the working directory.**
- **`git reflog`** → Shows previous `HEAD` positions; helps recover commits.
- **Reset vs Revert** → `reset` moves `HEAD` to an earlier commit; `revert` creates a new commit to undo changes.

### **git stash**

- **`git stash`** → Temporarily saves staged and unstaged changes; working tree becomes clean.
- **`git stash pop`** → Restores the latest stash and removes it; changes return unstaged by default.
- **Use case** → Put unfinished work aside without creating a commit.

### **git branch**

- `git branch` → List local branches; `*` marks the current branch.
- `git branch <name>` → Create a branch but dont switch to it.
- `git switch <branch>` → Switch to the specified branch.
- `git merge <branch>` → Merge the specified branch into the current branch.

### **git merge & conflicts**

- **Merge conflict** → Git cannot automatically combine different edits to the same part of a file.
- **Conflict resolution** → Choose the correct content and remove conflict markers.
- **Flow** → `git merge <branch> → resolve conflict → git add . → git commit`.
- **Steps** → Edit conflicted file → save → `git add .` → `git commit` to complete the merge.

### **GitHub — Remote & Push**

- **`origin`  →** Alias/name for the remote GitHub repository.
- `git remote add origin <URL>` →Saves the GitHub URL as the remote named `origin`.
- `git remote -v` → Show remote URLs for fetch and push.
- `git branch -M main` → Renames the current local branch to `main`.
- `git push -u origin main` → Pushes local `main` to remote `main` and remembers it as upstream.
- `origin/main` →  a **remote-tracking branch** stored locally.
- `git push -u origin master:main` → Pushes local `master` to remote `main` and remembers the branch relationship.
- master : main
    ↑             ↑
local    remote

### **GitHub - Fetch, Pull, Push & Clone**

- `git branch -a` → Show all branches including remote branches.
- `git fetch` → Downloads remote updates without changing files.
- `git pull` → Fetches and applies remote changes locally.
- `git push` → Uploads local commits to remote.

### **git clone**

- `git clone <URL>` → Downloads a remote repository locally.
- **Clone vs Pull** → Clone creates a local repository; pull updates an existing one.

### **git Fork**

- **Fork** → Creates your own GitHub copy of another repository.
- **`origin`** → Remote pointing to your fork.
- **`upstream`** → Remote pointing to the original repository.

### **Pull Request**

- **Pull Request** → It is a request to the repo owner to review and merge your code changes into their repository.

### **git branch delete**

- `git branch -D <name>` → Force-delete a local branch, even if unmerged.

### **git tag**

- `git tag <name>` → Create a name for a specific commit, commonly used for releases.

### **git rebase**

- `git rebase <branch>` → Move your commits to a new base commit.
- **Use case** → Keeps project history cleaner and more linear.

### **git squash**

- `git rebase -i <commit>` → Open interactive rebase to edit previous commits.
- **pick** → Keep the commit as it is.
- **squash (s)** → Combine the commit with the previous commit.

### **git force push**

- `git push --force` → Force-push local history to the remote.
- **Use case** → Used after history rewriting, such as rebase; can overwrite remote history.