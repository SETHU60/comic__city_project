package za.ac.cput.domain;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project

import java.util.Objects;

public class Author {
    private long authorID;
    private Name name;

    protected Author() {
    }

    private Author(AuthorBuilder a) {
        this.authorID = a.authorID;
        this.name = a.name;
    }

    public long getAuthorID() {
        return authorID;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Domain.Author{" +
                "authorID=" + authorID +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorID == author.authorID && Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorID, name);
    }

    public static class AuthorBuilder{
        private long authorID;
        private Name name;

        public AuthorBuilder() {
        }

        public AuthorBuilder setAuthorID(long authorID) {
            this.authorID = authorID;
            return this;
        }

        public AuthorBuilder setName(Name name) {
            this.name = name;
            return this;
        }
        public AuthorBuilder copy(Author a) {
            this.authorID = a.authorID;
            this.name = a.name;

            return this;
        }

        public Author build() {
            return new Author(this);
        }
    }

}
